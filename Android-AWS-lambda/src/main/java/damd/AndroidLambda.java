package damd;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;


public class AndroidLambda {


    // Define duas classes/POJOs para usar com a função lambda.
    public static class RequestClass {
        double latitude;
        double longitude;

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public RequestClass(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
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

        LatLng posicaoAtual = new LatLng(request.getLatitude(), request.getLongitude());
        double distancia, menorDistancia = 0;
        LatLng pucMaisPerto = new LatLng();
        boolean primeira = false;
        String responseString;

        ArrayList<LatLng> pucs = new ArrayList<>();
        pucs.add(new LatLng(-19.933209, -43.937179)); // praça da liberdade
        pucs.add(new LatLng(-19.924365, -43.991588));// coreu
        pucs.add(new LatLng(-19.859570, -43.919052)); // sao gabriel
        pucs.add(new LatLng(-19.976627, -44.027777)); //barreiro
        pucs.add(new LatLng(-19.954935, -44.198635));//betim
        pucs.add(new LatLng(-19.940546, -44.076264));//contagem

        for (LatLng l: pucs) {

            int a = (int) sin((posicaoAtual.longitude - l.longitude) / 2);
            int b = (int) sin((posicaoAtual.latitude - l.latitude) / 2);
            int potencia1 = a ^ 2;
            double raiz = sqrt((b ^ 2) + cos(posicaoAtual.latitude)) * cos(l.latitude) * potencia1;
            distancia = 2 * asin(raiz);

            if(primeira == false){
                primeira = true;
                menorDistancia = distancia;
                pucMaisPerto = l;
            }else if(distancia < menorDistancia){
                menorDistancia = distancia;
                pucMaisPerto = l;
            }

        }

        if(pucs.get(0) == pucMaisPerto){
            responseString = "liberdade";
        }else if(pucs.get(1) == pucMaisPerto){
            responseString = "coreu";
        }else if(pucs.get(2) == pucMaisPerto){
            responseString = "sao gabriel";
        }else if(pucs.get(3) == pucMaisPerto){
            responseString = "barreiro";
        }else if(pucs.get(4) == pucMaisPerto){
            responseString = "betim";
        }else if(pucs.get(5) == pucMaisPerto){
            responseString = "contagem";
        }else{
            responseString = "ta longe";
        }




        context.getLogger().log(responseString);
        return new ResponseClass(responseString);
    }
}