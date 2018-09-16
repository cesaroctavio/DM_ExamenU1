//1./////////////////////////////
import org.apache.spark.sql.SparkSession
import spark.implicits._
import org.apache.spark.sql.functions._
//2./////////////////////////////
val spar = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")
//3. y 4.////////////////////////////////////////
df.printSchema()
//5.///////////////////////////////////////
df.show(5)

df.select($"Date", $"Open", $"High", $"Low", $"Close").show()
//6.///////////////////////////////////////////
df.describe().show()

//7.//////////////////////////////////////////////
val df2 = df.withColumn("Hv Ratio", df("High")/df("Volume"))
df("High")
df2.printSchema()

df2.select(corr("High", "Volume")).show()
//8.///////////////////////////////////////////////////////
df.select(max("High"), max("Date")).show()

df2.select(df2("Hv Ratio").as("HV"), df("Date")).show()
//9.//////////////////////////////////////////////////
df.describe("Close").show()
//10.///////////////////////////////////////////////
df.select(max("Volume"), min("Volume")).show()
//11.////////////////////////////////////////////
//a.
println(s"Dias de cierre son: = ${ df.filter($"Close" < 600).count() }")
//b.
df.select($"High" > 500).count()
//c.
df2.select(corr("High", "Volume")).show()
//d.
df.select(max("Date")).show()
//e.
df.select(avg("Date")).show
