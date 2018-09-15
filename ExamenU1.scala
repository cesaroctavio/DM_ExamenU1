

//1.///////////////////////////////////////////
def isPrime(num:Int):Boolean={
  for(n<-Range(2, num)){
    if(num%n==0){
      return false
    }
  }
  return true
}
val NUMBA = scala.io.StdIn.readLine("Ingrese un número: ")
if(isEven(NUMBA.toInt))
    printf("El %d es par", NUMBA.toInt)
else
    printf("El %d es impar", NUMBA.toInt)
)

//2.//////////////////////////////////////////
def isPrime1(n: Int): Boolean = ! ((2 until n-1) exists (n % _ == 0))

val tests = List.range(1, 3)

for (n <- tests) {
    print(n)
    if (isEven(n)) {
        println(" -> Even")
    }
    if (isOdd(n)) {
        println(" -> Odd")
    }
}

//3.//////////////////////////////////////////

def suerte(list:List[Int]): Int = {
   var sum = 0
   for (i <- list){
       if(i == 7) sum += 14
       else sum += i
   }
   return sum
}
println("Lista: 1,2,3,4,5,6,7")
println("La suma es " + suerte(List(1, 2, 3, 4, 5, 6 ,7 )))
//4./////////////////////////////////
def listbalance(list:List[Int]): Boolean = {
   var primera = 0
   var segunda = list.sum
   for (i <- list){
       primera += i
       segunda -= i
       if(primera == segunda)
           return true
   }
    return false
}
if(listbalance(List(7,3,4))) println("Equilibrada") else println("No está equilibrada")

//5.//////////////////////
print("Palabra: RECONOCER -> ")
if("RECONOCER" == "RECONOCER".reverse) print("Es palíndroma") else print("No es palíndroma")
print("\n[+] Palabra: CESAR -> ")
if("CESAR" == "CESAR".reverse) print("Es palíndroma") else print("No es palíndroma")
