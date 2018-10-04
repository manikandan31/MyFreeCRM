pipeline{
agent any

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
