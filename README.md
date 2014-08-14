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
data stored in collections of Scala case classes.

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

<a name="usage"></a> 
### Usage Examples

The Scala code:

      @Test
      def basicTable() {
        val groceryList = Seq(
          GroceryItem("Milk", requestedBy = "kids"),
          GroceryItem("Eggs", requestedBy = "Mom"),
          GroceryItem("Cheese", requestedBy = "Mom"),
          GroceryItem("Beer", quantity = 12, requestedBy = "Dad"))
    
        val tabular = new Tabular()
        tabular.transform(groceryList) foreach logger.info
      }
    
      case class GroceryItem(item: String, quantity: Int = 1, requestedBy: String)

The output:

    2014-08-13 19:44:35 INFO  TabularTest:35 - + ------------------------------- +
    2014-08-13 19:44:35 INFO  TabularTest:35 - | item    quantity  requestedBy   |
    2014-08-13 19:44:35 INFO  TabularTest:35 - + ------------------------------- +
    2014-08-13 19:44:35 INFO  TabularTest:35 - | Milk    1         kids          |
    2014-08-13 19:44:35 INFO  TabularTest:35 - | Eggs    1         Mom           |
    2014-08-13 19:44:35 INFO  TabularTest:35 - | Cheese  1         Mom           |
    2014-08-13 19:44:35 INFO  TabularTest:35 - | Beer    12        Dad           |
    2014-08-13 19:44:35 INFO  TabularTest:35 - + ------------------------------- +

