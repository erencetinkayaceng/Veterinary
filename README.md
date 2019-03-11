# Veterinary
JSF , JPA , Maven
<h2>Veterinerlik hayvan takibi uygulaması </h2>

Gereksinimler:<br>
    Java Version 1.8.0<br>
    Dynamic Web Module 3.1<br>
    JavaServer Faces v2.2<br>
    Apache Tomcat-8.0.39<br>
    Hibernate 5.2.6<br>
    MySql Server 5.7<br>

<h4>Nasıl kurulur?</h4>
0- Projeyi githubdan indirin.
<br>1- Eclipse için File -> Open projects from File System ile projeyi eclipse import edin.
<br>2- Öncelikle bilgisyarınızda yüklü olması gereken veritabanı ugulamalarından mysql,postgresql vb. veritabanlarından birisinde veritabanı oluşturun.
<br>3. Projenin içerisinde src/META-INF dosyası altında bulunan persistence.xml dosyasından gerekli alanları doldurup bağlantı ayarlarını yapın.
<br>4. Projeye sağ tıklayıp Maven-> Update Project diyerek maven repolarından gerekli jar dosyalarını indirip projeye bağlanmasını sağlayın.
<br>5. Eclipse Servers panelinde sağ tıkla new->server tıklayıp açılan pencerede apache->tomcat v8.0 server -> server runtime enviromentda ADD bağlantısına tıklayıp tomcat v8.0 serverın dosya yolunu gösterin. Sonra next deyip projeyi Add ile ekleyin ve finish ile bitirin.
<br>6. Projeye sağ tıklayıp run configureden yeni oluşturduğumuz serverı seçin.
<br>7. Projeyi Run ile çalıştırarak kullanın.

<br>Not:Projede kullanıcı eklenirken Rol olarak standartRole ayarlıdır. Admin kullanıcı oluşturabilmek için UserManagedBean sınıfının 35. satırında bulunan Role kısmını adminRole olarak derleyip çalıştırdıktan sonra admin kullanıcısını oluşturun ve tekrar standartRole yaparak derleyip projeyi kullanmaya devam edin.  
![2019-03-11 22-31-43 ekran görüntüsü](https://user-images.githubusercontent.com/12209217/54153248-27f5bf80-4450-11e9-9943-1890d97b43bb.png)
![2019-03-11 22-31-50 ekran görüntüsü](https://user-images.githubusercontent.com/12209217/54153249-288e5600-4450-11e9-891e-8238067af820.png)
![2019-03-11 22-32-50 ekran görüntüsü](https://user-images.githubusercontent.com/12209217/54153250-288e5600-4450-11e9-988b-3c656ed9e44a.png)
