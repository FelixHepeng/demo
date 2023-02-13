package com.example.hp.jenkinstomq.service.impl;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.job.*;
import com.cdancy.jenkins.rest.domain.statistics.OverallLoad;
import com.cdancy.jenkins.rest.domain.system.SystemInfo;
import org.springframework.stereotype.Service;

@Service
public class JenkinsInfoAcquireServiceImpl {

    public void getSystemInfo(){
        JenkinsClient client = JenkinsClient.builder().endPoint("http://127.0.0.1:9999")
                .credentials("admin:fdb373346fef444893929b2e1959b7ac")
                .build();
        /**
         * Get jenkins items(projects/jobs)
         * param: folder path
         * if param entry "", means takes the outermost task, if you want to see the tasks
         * in the task folder, the entry is the filename name.
         */
        JobList jobList = client.api().jobsApi().jobList("");

        /**
         * Get item information according to item name.
         * param1: folder path(optional).
         * param2: item name
         */
        JobInfo jobInfo = client.api().jobsApi().jobInfo(null, "jenkins-to-mq");

        /**
         * Get build information based on item name and item build id.
         * param1: folder path (optional).
         * param2: item name.
         * param3: build number
         */
        BuildInfo buildInfo = client.api().jobsApi().buildInfo(null, "jenkins-to-mq", 3);

        /**
         * Get item profile content
         * param1: folder path (optional).
         * param2: item name.
         */
        String configInfo = client.api().jobsApi().config(null, "jenkins-to-mq");

        /**
         * Get item description
         * param1: folder path (optional).
         * param2: item name.
         */
        String description = client.api().jobsApi().description(null, "jenkins-to-mq");

        /**
         * Serial number of the last build
         * param1: folder path (optional).
         * param2: item name.
         */
        Integer lastBuildNumber = client.api().jobsApi().lastBuildNumber(null,"jenkins-to-mq");

        /**
         * Get the console output of the item/task build
         * param1: folder path (optional).
         * param2: item name.
         * param3: start line number of console output text
         */
        ProgressiveText progressiveText=client.api().jobsApi().progressiveText(null,"jenkins-to-mq",0);

        /**
         * Get the information about the steps of item build.
         * param1: folder path (optional).
         * param2: item name.
         * param3: build number(Number of a particular build)
         */
        Workflow workFlow=client.api().jobsApi().workflow(null,"jenkins-to-mq",17);

        /**
         * Get pipelineNode information
         * param1: folder path (optional).
         * param2: item name.
         * param3: build number(Number of a particular build)
         * param4: nodeId
         */
        PipelineNode pipelineNode=client.api().jobsApi().pipelineNode(null,"jenkins-to-mq",1,1);


        /**
         * Get jenkins system environment information
         */
        SystemInfo systemInfo=client.api().systemApi().systemInfo();

        /**
         * Get jenkins statistics
         */
        OverallLoad overallLoad=client.api().statisticsApi().overallLoad();

    }

}
