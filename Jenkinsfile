pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/esmanur-karatas/TestNgApiTestingExample.git' // GitHub repository URL'niz
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install' // Projeyi derle
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
                // JUnit veya TestNG sonuçlarını Jenkins'te görüntülemek için (isteğe bağlı)
                junit '**/surefire-reports/TEST-*.xml'
                testng '**/testng-results.xml'
            }
            post {
                always {
                    // Test sonuçları ne olursa olsun toplanır
                    recordTestResults publishHTML: [allowMissing = true, alwaysLinkToLastBuild = true, keepAll = false, reportDir = 'test-output', reportFiles = 'ExtentReport_*.html', reportName = 'Test Raporu']
                }
                failure {
                    // Testler başarısız olursa bildirim gönderilebilir (isteğe bağlı)
                    echo 'Testler Başarısız Oldu!'
                    // mail to: 'esmanurkaratas0@gmail.com', subject: 'Jenkins Build Başarısız', body: 'Testler başarısız oldu. Detaylar için Jenkins bakınız.'
                }
                success {
                    // Testler başarılı olursa bildirim gönderilebilir (isteğe bağlı)
                    echo 'Testler Başarılı!'
                    // mail to: 'esmanurkaratas0@gmail.com', subject: 'Jenkins Build Başarılı', body: 'Testler başarıyla geçti.'
                }
            }
        }
        stage('Report') {
            steps {
                // Extent Reports yayınlama (Test aşamasında zaten yapılıyor)
                echo 'Extent Report yayınlanıyor (Test aşamasında yapıldı).'
            }
        }
    }
    post {
        failure {
            echo 'Pipeline Başarısız Oldu!'
            // mail to: 'mail@example.com', subject: 'Jenkins Pipeline Başarısız', body: 'Pipeline genelinde bir hata oluştu. Detaylar için Jenkins bakınız.'
        }
        success {
            echo 'Pipeline Başarılı!'
            // mail to: 'mail@example.com', subject: 'Jenkins Pipeline Başarılı', body: 'Pipeline başarıyla tamamlandı.'
        }
    }
}