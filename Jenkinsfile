pipeline{
 agent any
 tools{
  maven : Maven_3.5.4
  jdk : Java
 }
  stages{

    stage('compile'){

      steps{

            sh  'mvn clean compile' 

          }
    }
    stage('Tesing stage'){
      steps{

            sh  'mvn clean test' 
            
           }
     }
   }
}
