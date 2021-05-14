## Prod'u ayağa kaldırmak için:
1. root dizininde "docker-compose up" komutunu çalıştır.
2. Değişiklik yapıldıktan sonra (ör. server komponentinde kod değişikliği):
   * Yeni bir .jar oluşturulur: "gradlew build && java -jar server/build/libs/server-1.0-SNAPSHOT.jar"
   * Docker imajı yeniden build edilir (komponent dizininde iken): 
     *  "docker build -t <server komponentinin adı> ."
    * Birinci adım tekrar çalıştırılır.