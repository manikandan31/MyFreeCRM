pipeline{
 agent any
  stages{

    stage('compile'){

      steps{
         withMaven( maven: 'Maven_3.5.4'){
            sh  'mvn clean compile' 
            }
           }
    }
    stage('Tesing stage'){
      steps{
         withMaven( maven: 'Maven_3.5.4'){
            sh  'mvn clean compile' 
            }
           }
     }
   }
}
