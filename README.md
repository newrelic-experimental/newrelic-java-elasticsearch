[![New Relic Experimental header](https://github.com/newrelic/opensource-website/raw/master/src/images/categories/Experimental.png)](https://opensource.newrelic.com/oss-category/#new-relic-experimental)

# ElasticSearch Instrumentation

>Instrumentation tracks and records ElasticSearch queries as DataStore queries

## Installation

> Either download the Release instrumentation jars or build them as described in the Building section below.   
In the New Relic Java Agent directory, create a directory named extensions if it does not already exist.   
Copy the instrumentation jars into the extensions directory.   
Restart the application

## Getting Started

> You should see ElasticSearch queries begin to show up in the New Relic UI under Databases for the application.

## Building

> To build the ElasticSearch instrumenation jars requires that Gradle is installed.   
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

