pipeline{
 agent any
 tools{
  maven 'Maven'
  jdk 'Java'
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
