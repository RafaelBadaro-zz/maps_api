package damd;

import com.amazonaws.services.lambda.runtime.Context; 

public class AndroidLambda {

    // Define duas classes/POJOs para usar com a função lambda.
    public static class RequestClass {
        String sensorName;
        String sensorValue;

        public String getSensorName() {
            return sensorName;
        }

        public void setSensorName(String sensorName) {
            this.sensorName = sensorName;
        }

        public String getSensorValue() {
            return sensorValue;
        }

        public void setSensorValue(String sensorValue) {
            this.sensorValue = sensorValue;
        }

        public RequestClass(String sensorName, String sensorValue) {
            this.sensorName = sensorName;
            this.sensorValue = sensorValue;
        }

        public RequestClass() {
        }
    }

    public static class ResponseClass {
        String responseString;

        public String getResponseString() {
            return responseString;
        }

        public void setGreetings(String responseString) {
            this.responseString = responseString;
        }

        public ResponseClass(String responseString) {
            this.responseString = responseString;
        }

        public ResponseClass() {
        }

    }

    public static ResponseClass myHandler(RequestClass request, Context context){
        String responseString = String.format("Sensor data: %s = %s.", request.sensorName, request.sensorValue);
        context.getLogger().log(responseString);
        return new ResponseClass(responseString);
    }
}