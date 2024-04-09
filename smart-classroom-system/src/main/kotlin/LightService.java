import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class LightServer {
    private int port;
    private Server server;
    private boolean isLightOn;
    private ScheduledExecutorService scheduler;

    public LightServer(int port) {
        this.port = port;
        this.isLightOn = false;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new LightImpl())
                .build()
                .start();

        System.out.println("Light Server started, listening on " + port);

        // Schedule energy optimization task
        scheduler.scheduleAtFixedRate(this::optimizeEnergy, 0, 1, TimeUnit.MINUTES);
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
            scheduler.shutdown();
        }
    }

    private void optimizeEnergy() {
        // Get current day of week and hour of day
        java.time.DayOfWeek dayOfWeek = java.time.DayOfWeek.from(java.time.LocalDate.now());
        int hour = java.time.LocalTime.now().getHour();

        // Automatically turn off light according to the schedule
        if ((dayOfWeek != java.time.DayOfWeek.SATURDAY && dayOfWeek != java.time.DayOfWeek.SUNDAY && hour == 22) ||
                (dayOfWeek == java.time.DayOfWeek.SATURDAY || dayOfWeek == java.time.DayOfWeek.SUNDAY)) {
            controlLight(false);
        }
    }

    private void controlLight(boolean turnOn) {
        isLightOn = turnOn;
    }

    private class LightImpl extends LightServiceGrpc.LightServiceImplBase {

        @Override
        public void getLightStatus(GetLightStatusRequest request, StreamObserver<LightStatus> responseObserver) {
            LightStatus lightStatus = LightStatus.newBuilder()
                    .setName("Classroom Light")
                    .setIsOn(isLightOn)
                    .build();
            responseObserver.onNext(lightStatus);
            responseObserver.onCompleted();
        }

        @Override
        public void controlLight(ControlLightRequest request, StreamObserver<LightControlResponse> responseObserver) {
            controlLight(request.getTurnOn());
            LightControlResponse response = LightControlResponse.newBuilder().setSuccess(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void monitorLightStream(MonitorLightRequest request, StreamObserver<LightStatus> responseObserver) {
            // Send current light status
            LightStatus lightStatus = LightStatus.newBuilder()
                    .setName("Classroom Light")
                    .setIsOn(isLightOn)
                    .build();
            responseObserver.onNext(lightStatus);

            // Stream updates if light status changes
            // For simplicity, we simulate light status changes every 5 seconds
            scheduler.scheduleAtFixedRate(() -> {
                LightStatus updatedStatus = LightStatus.newBuilder()
                        .setName("Classroom Light")
                        .setIsOn(isLightOn)
                        .build();
                responseObserver.onNext(updatedStatus);
            }, 0, 5, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LightServer lightServer = new LightServer(9090);
        lightServer.start();
        lightServer.server.awaitTermination();
    }
}
