def call(String project, String service, String buildNumber, String path, String contextPath) {
    def registry = "287441713712.dkr.ecr.eu-west-1.amazonaws.com"
    def imageTag = "${registry}/${project}-${service}:${buildNumber}"

    // docker.build("${registry}/demo-service:${BUILD_NUMBER}", "-f ./src/demoservice/Dockerfile ./src/demoservice")
    docker.build("${imageTag}", "-f ${path} ${contextPath}")

    // sh "docker image build -t ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER} ."
    // withCredentials([usernamePassword(
    //         credentialsId: "docker",
    //         usernameVariable: "USER",
    //         passwordVariable: "PASS"
    // )]) {
    //     sh "docker login -u '$USER' -p '$PASS'"
    // }
    // sh "docker image push ${hubUser}/${project}:beta-${env.BRANCH_NAME}-${env.BUILD_NUMBER}"
}