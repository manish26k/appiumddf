node{
     stage('SCM Checkout'){
        git 'https://github.com/manish26k/appiumddf/'          
     }
     stage('Complie-Package'){
        def mvnHome = tool name: 'MAVEN_HOME', type: 'maven' 
          bat "${mvnHome}/bin/mvn package"
     }
     
}
