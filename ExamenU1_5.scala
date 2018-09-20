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
df.columns

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
df.select(mean("Close")).show() //El close tiene proposito de desplagar los cierres de ventas en Netflix_2011_2016
//10.///////////////////////////////////////////////
df.select(max("Volume"), min("Volume")).show()
//11.////////////////////////////////////////////
//a./////////
println(s"Dias de cierre son: = ${ df.filter($"Close" < 600).count() }")
//b.//////////
df.select($"High" > 500).count()
//c.////////
df2.select(corr("High", "Volume")).show()
//d./////////
df.select(max("Date")).show()

val dfyear = df.withColumn("Year",year(df("Date")))
val maxyear = dfyear.select($"Year",$"High").groupBy("Year").max()
val res = maxyear.select($"Year",$"max(High)")

res.orderBy("Year").show()
//e///////////.
df.select(avg("Date")).show

val  = df.withColumn("Month",month(df("Date")))
val monthavgs = monthdf.select($"Month",$"Close").groupBy("Month").mean()

monthavgs.select($"Month",$"avg(Close)").orderBy("Month").show()
