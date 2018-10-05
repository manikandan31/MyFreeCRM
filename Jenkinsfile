pipeline{
 agent any
 tools{
  maven 'Maven'
  jdk 'Java'
 }
  stages{

    stage('compile'){

      steps{

            bat  'mvn clean compile' 

          }
    }
    stage('Tesing stage'){
      steps{

            bat  'mvn clean test' 
            
           }
     }
   }
}
