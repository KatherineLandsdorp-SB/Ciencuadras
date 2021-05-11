pipeline
        {
            agent any // run the pipeline on any available node
            tools {
                gradle 'gradle'
            }
             stages
            {
                stage('SCM: code update')
                {
                     steps
                    {
                          // checking out repository
                        git branch: 'candidate-v0.0.4.2', credentialsId: 'eidarraga', url: 'https://github.com/segurosbolivar/bol-automation-ciencuadras-test.git'
                    }
                 }

                stage('gradle')
                {
                    steps
                    {
                       sh "./gradlew clean build"
                     }
                }

                stage('test')
                {
                    steps
                    {
                       sh "./gradlew test"
                     }
                }
            }

        }