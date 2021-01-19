pipeline
        {
            agent any // run the pipeline on any available node
            tools {
                jdk 'jdk8' 
            }
             stages
            {
                stage('SCM: code update')
                {
                     steps
                    {
                        script
                        {
                           // checking out repository
                            git branch: 'test',
                            credentialsId: 'holmansnc',
                            url: 'https://github.com/segurosbolivar/bol-automation-ciencuadras-test.git'
                        }
                    }
                }
                stage('gradle')
                {
                    steps
                    {
                        script
                        {
                            //copying and building gradle
                            	steps {
                                    sh './gradlew build'
                                }
                        }
                    }
                }
                
            }
        }