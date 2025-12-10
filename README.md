<a href="https://opensource.newrelic.com/oss-category/#new-relic-experimental"><picture><source media="(prefers-color-scheme: dark)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/dark/Experimental.png"><source media="(prefers-color-scheme: light)" srcset="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"><img alt="New Relic Open Source experimental project banner." src="https://github.com/newrelic/opensource-website/raw/main/src/images/categories/Experimental.png"></picture></a>
 
![GitHub forks](https://img.shields.io/github/forks/newrelic-experimental/newrelic-java-elasticsearch?style=social)
![GitHub stars](https://img.shields.io/github/stars/newrelic-experimental/newrelic-java-elasticsearch?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/newrelic-experimental/newrelic-java-elasticsearch?style=social)

![GitHub all releases](https://img.shields.io/github/downloads/newrelic-experimental/newrelic-java-elasticsearch/total)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/newrelic-experimental/newrelic-java-elasticsearch)
![GitHub last commit](https://img.shields.io/github/last-commit/newrelic-experimental/newrelic-java-elasticsearch)
![GitHub Release Date](https://img.shields.io/github/release-date/newrelic-experimental/newrelic-java-elasticsearch)


![GitHub issues](https://img.shields.io/github/issues/newrelic-experimental/newrelic-java-elasticsearch)
![GitHub issues closed](https://img.shields.io/github/issues-closed/newrelic-experimental/newrelic-java-elasticsearch)
![GitHub pull requests](https://img.shields.io/github/issues-pr/newrelic-experimental/newrelic-java-elasticsearch)
![GitHub pull requests closed](https://img.shields.io/github/issues-pr-closed/newrelic-experimental/newrelic-java-elasticsearch)  
   
# New Relic Java Instrumentation for ElasticSearch

Instrumentation tracks and records ElasticSearch queries as DataStore queries

## Installation

1. Either download the Release instrumentation jars or build them as described in the Building section below.   
2. In the New Relic Java Agent directory, create a directory named extensions if it does not already exist.   
3. Copy the instrumentation jars into the extensions directory.   
4. Restart the application

## Getting Started

You should see ElasticSearch queries begin to show up in the New Relic UI under Databases for the application.

## Long Query Support with Logs in Context

This instrumentation automatically logs complete Elasticsearch queries to New Relic Logs with full trace correlation, overcoming the attribute size limitations for large queries.

### Required Configuration

To enable logs in context for Elasticsearch queries, ensure the following is set in your `newrelic.yml`:

```yaml
application_logging:
  enabled: true
  forwarding:
    enabled: true
    context_data:
      enabled: true  # Required for trace correlation
```

### Optional Configuration

The following settings have sensible defaults and are optional:

```yaml
# Enable/disable logs in context for long queries (default: true)
elasticsearch.query.logs_in_context.enabled: true

# Threshold for logging queries in characters (default: 4093)
elasticsearch.query.logs_in_context.threshold: 4093

# Enable/disable query splitting into custom attributes (default: true)
# REST client only - maintains backward compatibility
elasticsearch.query.split_attributes.enabled: true
```

### How It Works

**For queries ≤ 4093 characters:**
- Full query visible in transaction trace (no chunking or logging overhead)

**For queries > 4093 characters:**

**REST Client (esrestclient-7.10):**
- First 4093 chars in main query field
- Remaining query split into 255-char chunks as custom attributes (`query_part_002` through `query_part_063`)
- Complete query logged to New Relic Logs with trace correlation
- **Max attributes capacity:** ~19.8KB
- **Max logs capacity:** Unlimited

**Transport Client (elasticsearch-2.x through 7.14):**
- Full query passed to `slowQuery()` (truncated by agent at 4093 chars)
- Complete query logged to New Relic Logs with trace correlation

### Configuration Scenarios

#### Default (Backward Compatible)
No configuration needed. Both attributes and logs enabled:
- ✅ Custom attributes for queries up to ~19.8KB
- ✅ Complete queries in logs (unlimited size)
- **Best for:** Maximum visibility and backward compatibility

#### Logs Only (Avoid Attribute Limits)
```yaml
elasticsearch.query.split_attributes.enabled: false
```
- ❌ No custom attribute chunks
- ✅ Complete queries in logs only
- **Best for:** Very long queries (>19.8KB) hitting attribute count limits

#### Attributes Only (Original Behavior)
```yaml
elasticsearch.query.logs_in_context.enabled: false
```
- ✅ Custom attribute chunks (up to ~19.8KB)
- ❌ No logs
- **Best for:** Customers who prefer attributes over logs

### Viewing Complete Queries

1. Navigate to APM → Transactions in New Relic
2. Select a transaction with a long Elasticsearch query
3. Click the **"Logs"** tab to see the complete query
4. Logs are automatically correlated with trace context

## Building

To build the ElasticSearch instrumenation jars requires that Gradle is installed.   
   
Set the environment variable NEW_RELIC_EXTENSIONS_DIR to a local directory.  If building on the same machine as the application use the extensions directory of the New Relic Java Agent.   
To build one of the modules (e.g elasticsearch-5.x) use the following command.   
gradle elasticsearch-5.x:clean elasticsearch-5.x:install.  
   
To build all of the instrumenation jars, use the following command.    
gradle clean install

## Support

New Relic has open-sourced this project. This project is provided AS-IS WITHOUT WARRANTY OR DEDICATED SUPPORT. Issues and contributions should be reported to the project here on GitHub.

>We encourage you to bring your experiences and questions to the [Explorers Hub](https://discuss.newrelic.com) where our community members collaborate on solutions and new ideas.

## Contributing

We encourage your contributions to improve [Project Name]! Keep in mind when you submit your pull request, you'll need to sign the CLA via the click-through using CLA-Assistant. You only have to sign the CLA one time per project. If you have any questions, or to execute our corporate CLA, required if your contribution is on behalf of a company, please drop us an email at opensource@newrelic.com.

**A note about vulnerabilities**

As noted in our [security policy](../../security/policy), New Relic is committed to the privacy and security of our customers and their data. We believe that providing coordinated disclosure by security researchers and engaging with the security community are important means to achieve our security goals.

If you believe you have found a security vulnerability in this project or any of New Relic's products or websites, we welcome and greatly appreciate you reporting it to New Relic through [HackerOne](https://hackerone.com/newrelic).

## License

ElasticSearch Instrumentation is licensed under the [Apache 2.0](http://apache.org/licenses/LICENSE-2.0.txt) License.

