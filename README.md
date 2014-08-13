Tabular
=======

A utility class for generating ASCII/text-based tables

Table of Contents

* <a href="#motivations">Motivations</a>
* <a href="#development">Development</a>
	* <a href="#build-requirements">Build Requirements</a>
	* <a href="#getting-the-code">Getting the code</a>
	* <a href="#configuring-your-ide">Configuring the project for your IDE</a>
	* <a href="#building-the-code">Building the code</a>
	* <a href="#testing-the-code">Running the tests</a>	
* <a href="#usage">Usage Examples</a>

<a name="motivations"></a>
## Motivations

There are many instances where I've needed a simple lightweight tool for generating tables for tabular
data stored in collections of Scala case classes and Java beans.

<a name="development"></a>
## Development

<a name="build-requirements"></a>
### Build Requirements

* SBT 0.13+

<a name="getting-the-code"></a>
### Getting the code

    $ git clone git@github.com:ldaniels528/tabular.git

<a name="configuring-your-ide"></a>
### Configuring the project for your IDE

#### Eclipse project
    $ sbt eclipse
    
#### Intellij Idea project
    $ sbt gen-idea

<a name="building-the-code"></a>
### Building the code

    $ sbt clean publish-local
    
<a name="testing-the-code"></a>    
### Running the tests

    $ sbt test    

### Usage Examples

The Scala code:

    val groceryList = Seq(
      GroceryItem("Milk"),
      GroceryItem("Eggs"),
      GroceryItem("Cheese"))

    val tabular = new Tabular()
    tabular.transform(groceryList) foreach(logger.info)

The output:

    2014-08-13 15:59:05 INFO  TabularTest:21 - + ------------------ +
    2014-08-13 15:59:05 INFO  TabularTest:21 - | name    quantity   |
    2014-08-13 15:59:05 INFO  TabularTest:21 - + ------------------ +
    2014-08-13 15:59:05 INFO  TabularTest:21 - | Milk    1          |
    2014-08-13 15:59:05 INFO  TabularTest:21 - | Eggs    1          |
    2014-08-13 15:59:05 INFO  TabularTest:21 - | Cheese  1          |
    2014-08-13 15:59:05 INFO  TabularTest:21 - + ------------------ +

