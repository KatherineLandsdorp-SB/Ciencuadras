pipeline
        {
            agent any // run the pipeline on any available node
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
                stage('Docker build')
                {
                    steps
                    {
                        script
                        {
                            // copying and building gradle
                            docker.build("bolivar/gradle")
                        }
                    }
                }
                
            }
        }