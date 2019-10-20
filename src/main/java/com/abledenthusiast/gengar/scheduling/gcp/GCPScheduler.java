package com.abledenthusiast.gengar.scheduling.gcp;


import com.google.cloud.tasks.v2beta3.CloudTasksClient;
import com.google.cloud.tasks.v2beta3.HttpMethod;
import com.google.cloud.tasks.v2beta3.HttpRequest;
import com.google.cloud.tasks.v2beta3.QueueName;
import com.google.cloud.tasks.v2beta3.Task;
import com.google.protobuf.ByteString;
import java.nio.charset.Charset;

import java.io.IOException;
import java.util.logging.Logger;

public class GCPScheduler {

    public static void createTask(String projectId, String locationId, String queueId)
            throws Exception {

        // Instantiates a client.
        try (CloudTasksClient client = CloudTasksClient.create()) {
            String url = "https://example.com/taskhandler";
            String payload = "Hello, World!";

            // Construct the fully qualified queue name.
            String queuePath = QueueName.of(projectId, locationId, queueId).toString();

            // Construct the task body.
            Task.Builder taskBuilder =
                    Task.newBuilder()
                            .setHttpRequest(
                                    HttpRequest.newBuilder()
                                            .setBody(ByteString.copyFrom(payload, Charset.defaultCharset()))
                                            .setUrl(url)
                                            .setHttpMethod(HttpMethod.POST)
                                            .build());

            // Send create task request.
            Task task = client.createTask(queuePath, taskBuilder.build());
            System.out.println("Task created: " + task.getName());
        }
    }

//    @WebServlet(
//            name = "Tasks",
//            description = "Create Cloud Task",
//            urlPatterns = "/tasks/create"
//    )
//    public class TaskServlet extends HttpServlet {
//        private static Logger log = Logger.getLogger(TaskServlet.class.getName());
//
//        @Override
//        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//            log.info("Received task request: " + req.getServletPath());
//            String body = req.getReader()
//                    .lines()
//                    .reduce("", (accumulator, actual) -> accumulator + actual);
//
//            if (!body.isEmpty()) {
//                log.info("Request payload: " + body);
//                String output = String.format("Received task with payload %s", body);
//                resp.getOutputStream().write(output.getBytes());
//                log.info("Sending response: " + output);
//                resp.setStatus(HttpServletResponse.SC_OK);
//            } else {
//                log.warning("Null payload received in request to " + req.getServletPath());
//            }
//        }
//    }
}
