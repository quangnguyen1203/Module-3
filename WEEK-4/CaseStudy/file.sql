CREATE DATABASE  IF NOT EXISTS `casestudy` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `casestudy`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: casestudy
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accounts`
--

DROP TABLE IF EXISTS `accounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `accounts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(45) NOT NULL,
  `isSell` int NOT NULL DEFAULT '0',
  `isAdmin` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES (1,'admin','admin','admin@gmail.com',1,1),(2,'quang','123','quang@gmail.com',1,0),(3,'khánh','123','khanh@gmail.com',1,0),(4,'nam','123','nam@gmail.com',1,0),(5,'long','123','long@gmail.com',0,0),(9,'chuong','123','chuong@gmail.com',0,0),(10,'binh','123','binh@gmail.com',0,0);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `c_id` int NOT NULL AUTO_INCREMENT,
  `c_name` varchar(250) NOT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Adidas'),(2,'Nike'),(3,'Converse'),(4,'Gucci'),(5,'Louis Vuitton'),(6,'Puma'),(7,'Clothing');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `image` text NOT NULL,
  `price` double NOT NULL,
  `title` varchar(200) NOT NULL,
  `description` longtext NOT NULL,
  `cat_id` int NOT NULL,
  `sell_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cat_id` (`cat_id`),
  KEY `sell_id` (`sell_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`cat_id`) REFERENCES `categories` (`c_id`),
  CONSTRAINT `products_ibfk_2` FOREIGN KEY (`sell_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Nike Air Force 1 \'07 LV8','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/8846e5a9-055b-42ce-9bd8-09f2ad4eaaae/air-force-1-07-lv8-shoe-ldZ4Ml.png',100,'White/White/Black/Obsidian','The radiance lives on in the Nike Air Force 1 \'07 LV8, a hoops-inspired \'82 original with at least 20% recycled content by weight. The iconic star-tipped outsole features cork-infused rubber for a classic look. The embroidered botanical design on the tongue and scientific infographic vary by colour and celebrate the plant dye featured in the design.',2,2),(2,'LV Louis Vuitton VIP90','https://louiskimmi.vn/wp-content/uploads/2020/04/tui-nu-LV-ch%C3%ADnh-hieu.jpg',500,'Túi xách nữ','Chất lượng sản phẩm như hình ảnh mô tả trên website.',5,1),(3,'Gucci 1955 Horsebit','https://hoangnguyenstore.com/wp-content/uploads/2020/08/tui-deo-cheo-gucci-03.jpg',400,'Outer: Canvas 100%, Leather 100%','Gucci recreates an archival design that dates back to 1955, merging original House codes of beige monogram canvas and also draws attention to their equestrian roots with the Horsebit detail to the front of the flap closure on the bag. Adjust the strap to wear on the shoulder or across the body, Gucci would never leave you without options, Featuring an adjustable shoulder strap, a monogram pattern, a front flap closure, a horsebit detail, interior compartments divided by a partition and an internal zipped pocket.',4,1),(4,'Nike Air Force 1 Para Noise','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqa23XnbetasW6oWM56Nv8u9pqO6Nnnw4t3g&usqp=CAU',200,'Air Force 1 “G-Dragon Peaceminusone Para-Noise” ','Supplied by a premier sneaker marketplace dealing with unworn, already sold out, in demand rarities. Each product is rigorously inspected by experienced experts guaranteeing authenticity. The G-Dragon x Nike Air Force 1 Low \"Para-Noise\" is the Korean pop star’s interpretation of one of his favorite childhood shoes. The international superstar fondly recalls memories of wearing oversized clothes, hats and matching Air Force 1s once upon a time, and that sentiment serves as the inspiration behind this limited collaboration. Using premium black leather as a base for the upper, Dragon opts for a simple white leather Swoosh on the mid-panel with contrasting white laces and a cheery flower motif on the tongue. When worn away, the black leather reveals the artist’s artwork underneath the leather construction.',2,1),(5,'ULTRABOOST 20 Signal','data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkLDRYPDQwMDRsUFRAWIB0iIiAdHx8kKDQsJCYxJx8fLT0tMTU3Ojo6Iys/RD84QzQ5OjcBCgoKDQwNGg8PGjclHyU3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3Nzc3N//AABEIAL4AvgMBIgACEQEDEQH/xAAcAAEAAwEBAQEBAAAAAAAAAAAABQYHBAMIAQL/xABAEAABAwMCAwUFBAgEBwAAAAABAAIDBAUREiEGMUETIlFhcRQygZGhB1Kx0RUjQmJy4fDxFiRDwSVTZIKSwtL/xAAZAQEAAwEBAAAAAAAAAAAAAAAAAQIDBAX/xAAoEQADAAIDAAEDAgcAAAAAAAAAAQIDERIhMQQiQWEyURMjcZGh4fD/2gAMAwEAAhEDEQA/ANhREUkBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAOfJFnvG0091gvlLDNKw0DWywGN5b3mNBcNvIu+ngpz7Oby+98J0s1RKZKmHME7nHcubyJ9RpPxQJ7LMiIgC5au4UtFNBFVStiM7tMZdsCfBdSg+L7NFebPLE92lzGktcOn9EAjzCrbaW0XhKq0ycRZ/wvdOJLPS9nfqdlRRxtJEwnaXtb0xk97bxwfjsrvbq+luVK2poZmyxO6jmD4EHcHyKlNPwhpr06URFJUIiIAiIgCIiAIiIAiIgCIiAIOaLivNX7Fa6ifOHBmGfxHYICmWWT/idTLNgiWZ/aA9QScj/ZVjhW7DgPjCttFweW22d4aZDyj/5cnpg4J+PRWe3W0Q9maeUdm4Zc082n8ivPjThEcR0sVRSSMjuNOzS0u2ErOeknpg8j6qTGaSZobXBzQ5pBaRkEHYr9Xz7BeOMeEP8AKCSspYW7NjmjEkQ/hJBGPRfk32g8a1QLKWveXnZoigiG/wD4qH0brvw+gicAknACp104kbdZXUlol1UUZxPVs92U/cYeo8XcjyHVZvPfLxdoW/4iuftbGgD2Cn7kLiOshHvn93cKWpeJXsFBC6ljjidVxtlmZ7rGcz3ee+nCyr6uvsar+X36y7VFtqrjSNhkq30URaBlg1PcPIdP69VW7fw9deH7trtl3h7A9572g5k8ns5fVWZ/FFsaCYTNI4ggER4/HC/jhueGd5dXzvFUXZjeQAPXrv8ARVyxT0sf9yvx8iSby9/j9zrsPFdJdap1LHJHK5mxkjBDSc42zz5HkVZFVbtQUcV2ZURwQMrJWESTxHHaAkY1DkTtz5pcbzW2KGJ0oNTTag3tWjLQ3zKxnM8duK2/ydNYZywrn6d/YtSLmoa2CtiD4JGkkBxbncArpXZLVLaOOpcvTCIikgIiIAiIgCIiAIiIAqtx/VsprfTNleGRmQyPcejWtOfqQrSsZ+1y7S3biKnsNuxN2TQ17WnOqQ76fQDST6IGcFF9okUFWWvpHmnHJweNXrj+avFm4ts9y0tpq1glP+lJ3HfI8/gqFP8AZzVmmYYq6KSbGXMe3u58iq5ceGbtbGudU0crYhze3vsUmfGa8PoB8k1Tb6hlFL2dQ+JzYnjHdcQcH5rFX+0/oM1MMTqe5WWuJnh31EA7avHbr4ZX98DcS1NquMUdRUP9je4MkDiSGZ5OHh/dXPj62VDmm8WAkXN7WwVUEcQeKph2BwQRqGfllZ5YdLo2wWsVNV4yCZBSSzVVy9sgioblA1xjkfhzJMe8PNRdtmFVQNMjBq7YP1jkdORt5ZKhncK30Fzp7TURMYC49ppY0D1Jwpex2+unpooQwQRsJDpHb9c4aOp3WePDw9ezfL8j+I+lr/ZL08809QylpIzNUP8AdY0fU+AVvh4UvFNSOqW1PbVZGeyikIEe+fdOz/jv4Ec1x2RlPaIC2mboc735XHvO9T81wVfG9xraz9H2EOLWytY6eIgmX7zRt3QM8/8AZautGMy2WqihhbdKetvERpJYozLFpqu6GA4/WDYA5O2c9e90U7c6egrbRWS00jGslp3lxaA5jxg7lvI+v1XBwpZ46drZrg7tKonUGatTYz45PN3nuemcKN4lrIbPUVMNsuZNVITNJDGxhLHHAy87BoIAGAWnmdysOFV20bOpnpV4RZdFC6kqKeV49ni0tdE/TqG2BkenLbKslm4kZVRMdI7tI37NlaCPmCFTqB9PLXMoDT1FG2ePvtfFoD3YOrT1xnOMgbKe7MslipaalLh2eYgxuGDAO2rpyXLk5YeMxt1/32OvHxzcryLU/wCS3UVbSV8PbUNTDUR/eieHD6LoWEX6yXXhKcXelrPY5JJcBrZQHknfkPeHlyV94Q4+bcmx0t4j7Cu05JAw2TzH5fivQdqf1HnzDv8ASXpF5Q1EM4zDKx/kDuvVWTTW0UaaemERFJAREQBEX8ve2NjnvcGtaCXE8gAgIDjniKPhzh+pqhK1lW5hbTNLdWp+3Tw3WVfZ1bnzXCprpXB85aCA44cNRJJ35k/n4rg+0a6vvV+kqBUPdA3EcUXSPbJwPkSfHboFXqKvu9jmZNSvkhL2gjU3Ae30OxHmpIfaNuZURa9Bfpf907H5Lo1NLS04c1wwWnkR4LMrf9pMzHRm7WymqXR50yhulzPxH4L9uvGDp5o6uzVMkYIAkpZWDA/eaRn4hQ3poznE2m/2I7iW1Cw3qaIMLqOcF0RzyHT4tP09VbOEuMYYLZDSTRtfWh4iic94a17Tyy88vTbKql1v9Re6Qw1dPCHRDU15dpPTl+ShI3taeyfu1+ynZfjtaZpF/rqQ3H2S9XeGaoBD+xiH6iI+GfHPiklwoqSNznTsfoAJbEQ4gHlss4dRTGIPLQYxthrxn5c/oum3NioyJZpAwkamMafA7E+H4/FVrbXRpCUvstzxV3qpDmsEFPHyznI8/XHx9OambZDFamjsh078j+Z/IKMsFwq5aB9VWtp47dG06H4w5xGcgAe9/fJ6KErblV3ucwsc2GlJx7+kAeLnf15Ksxx99L3l59Lwtlw4sndA6ntMhMr2H9aM5/7R1Pmuz7N+DomV36TudVIZgdTKcO/a37z3cyd/5lQ9voI6GnbocJNI3mOPoh4qqadroLO4B5yHVJ3Df4R1Pn6c0lNb2Rbl6Uo1K/VVmZLFQ1EEVTWyDTFTMwH4JHM/ssOBnP1UZUCj4cop6+rLQ94AbT0zTpJHJrBzLj1d4DOAFmlrrK2juYr7fG+ruW+pzyT2mdjqOc4/luuW53G4VVbLPcql01YQY3MBLY4x9wNHTy59fNNTv8kfXrX2Om7Pl4guM1TXuLv2W9GRgHYNHQZ+JUaY3TkQluZJnhjQ5unbxx0HPn4hecNWQXvZK7GMEu7oHifIY6dVYuGXU8rRVzRdvPFIxrMPI7IPcA0gdSeeOgHMKtQ6ZpjyLGtFvoy+mpIIqh3aSMYA57hucfzXey4mmjMskz42DmXPJaPAbqAkvbDr7OCJuQ10cj5A1r2946iQCQNLC7rsW8ulKut4nra6eR5w2XaEYyG5Y1zd+W+cKJxaIeZV6jVDfmTd2C6QNdpBHeYPXmFzuu1VTFr5Lo+djiQNLYyNufus2wsmfMXSHTkjS7sZCckDoT8Wn1B3XTbDXtkLqSp7F8eXaWHAcW7nbflvv5kdVW8fX6mi+PI96Upmlu43jppGtnjednFwcW6iB1AHPOdlZ7bdKS5Ra6SUP7jXlvIgOzg/Q/IrGpHQshifENEYJa6MdBsTjwBacj95gKt32VvkNxuMD/8ARia0kctpHjA+RPxU4bb+lj5GNTqp62XeS50schYXOJHPDTsoXja9QU/ClxlhlGvs9IBGM5IGN/VTtwggkp3vmZnSM5aO8qrUwwVcElPUMbJDIMOa7fK2OYxmNvZUzKl51Paxzu9vlzjlaXwzqunCVI24RRzvLCNLmAggEgbemFA37gWRlPIbLUB7CD/lZ3cv4Xfn81K2DiO209PBb6tz7fVQMZH2dS3TqIGM6vdOefNGk1pkOnLVJeEXdrVws2WeOeCelmi9404JHjkDcfgqnHaqCvvkdBb6kGKY6YqioYWZcRsCACRk7ZV94tpXT1Edwp4nPjdHpeWjPLk7b+tlQq+B9FVR1FMcAPD43D9lwOVliU+zWzozVb6uUmdd64MvFlh7aoA7HVp1xSh4zjPI78geihooHhrpHOL8Ed7GwWwPrGcX8Ltkt4aahsjO0ic/Bid1B8t8g+Cz/iyzNsN0jppHtk7SESubHkN1EkYHyW7OaK30/TmtVPTTwOZNFiYnY5IJHkV6zWnJLqebO3KQA/Ve9LwtfKjsZm0zonF2T2jhGIx02O/yCtcHC0uxnrsdS1jc/UrC8+OfWdUfGy34igTU1TTxBj43hm+zM4+hXM+d726GSuYwcmgAgn1WrU9jpqd4d2bKjfOmYnHyGFxcXcKi7xR1Vvo4qWrjbp/VbMlHgR0O/P4FTizTl3xK/Iw3g1z+5RbDTVV0qm2ylEQdJGXAF+h0hG+nPLlnZTk1lu9Iwme1VTII3APMbdZx1I05zj5lVuhqJLLxBBUTNdFLSVDTLG4Yc0AjUPllbvBV08rWvina4OOQcEah4rXic9ZHLT1tGIXK6Q0N7jqrY2rhDGaZGT5jLh1AB3AP47he9fSx3Q+22udgIZlwcdOw5k/d26HyycnCmeILtHfOI62ZumamomiKnzggjfU4ep+gCjOFRQW+qguNzFO6jc4slL487AjDh6EA7dMrN4tacvs6Jz7TVLohZfbKSV0FTE8EO3Y8dT4H+67sOhEDg50Tg1rmnkWg8j9fkQtdrOH7S0tfHSR6Xk5cHHfI55z+8fmo+ooeG2l3tjKLLfeEkuSOhGM+AWN53F8WjaMEZI5qtf1M6pblMy5Gokw8yOiMrSAA7I3HwDtPkFyVNxgLaYBpa7sO8S7k4SHA9MbK90d74TpuIDSOt1DJRyaWx1jIQ7TIeeSenIZ6Y8F18Z8LUFDBJc7RAKZxOiWBjQGOB6gDGN8eS6IfKd6OS3M3xM+bHUVTWupYXyMEhw7HdGwxudun1K9aaomtswmngeCCNjyJDT19SCvWkuswo3QwxSPqmEgRtYXHrv8ABS/Dtpud2dDHXRPpqYg9pVTs3I6YZsT68lLlNaZaacvaK02vrXvjip2tcdQwCzVqOAMY5nly81s32d2WvtlJUV14e91dWFuWPxmNgzgYGw5k4HL1yvbhngmz2KY1kLTVVZyWzy47gPRgGw9easyhSl4RV1XrC5J7dST5L4QCere6foutFYqVm58IsrB+ouVTTnwDQ4f7Kn3L7JK2rc4tv8ZJP+rTE/8AstWRAY5TfZdxXbSf0df6Rjf3XSsz8ACF71PAXGdRCY6mrs1S1wwS8d8Hx1aMrXEUcUX51rWzIbHwHxlY6p9Tb57UHvZoc2SV5a4eYDea/q9cDcX3uvirK42oSRtDB2crgMAk+B8VriKSmu9mcU9l47ghZE5tml0DGp00mSPM4Xt+i+N8k+zWM+XbyfktBRYv4+J96OhfKzJaVGeOtnHIIxRWMgf9TJ/8r+2Q8bwM0mx2uZu+BHcC38WrQEVpxRD3K0Uy5ryzxt7RjvFnDfE19DJZeF44qtg0ieCujfqb90g4+C92v4speGxbv8N1/tTIeybUscxwA5ZwHZzp+oWtotDHitaPna32m823tBNYbth2PdopDy+C8rhS1s1MyGO0XKPD9Tmuo3t8fLzX0dyTJ8ULGY2/i+ko7ZTU01svT5I4Q0/5B/MDoSoLiG7uulYKq28O3syacS5o3d49D3c9PHwC2zJ8SvxCilLw+chYL5cZz7Jw7c2B5911M9gHxcAFbHWbjy8RR01yiqhTNABjMscbTjlnByVsKIW6KNY+DKq2sIi9kp9YHaFpc9x9SRv81ZaaywxkOmkfKR0OwUoiA/GgNADQAByAX6iIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiIAiIgCIiAIiID//Z',220,'BREAKING, BREAKING RUNNING ','Life values are the guiding principles for your life, shaping your running habits and style. Show those values on your feet with these adidas running shoes. The supportive, flexible shoe body uses plastic material collected from the coast and coastal areas. Generous colors show that you\'re not afraid to be the center of attention. Recycled material shows your willingness to protect the green planet. ',1,2),(6,'ULTRABOOST 20','https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy/73a74629da924dd0b185aaea00ddd47e_9366/Giay_UltraBoost_20_Xam_EG0715_01_standard.jpg',220,'HIGH PERFORMANCE RUNNING','Confidence from the ground up. This adidas running shoe is designed to keep you up to speed on your everyday running miles. Knitted upper for support from the inner seams based on motion capture technology. Soft, comfortable elastane heel allows natural heel movement. Elastic cushioning for smooth movement and fluid energy.',1,2),(8,'Nike Pegasus Trail 3','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/0bc465c9-6813-46cf-899c-f08f946010d0/pegasus-trail-3-trail-running-shoe-zzBdpt.png',343,'RUGGED AND RESPONSIVE.','Find your wings with an off-road run.The Nike Pegasus Trail 3 has the same cushioned comfort you love, with a design that nods to the classic Pegasus look.It\'s got tough traction to help you stay moving through rocky terrain.More support around the midfoot helps you feel secure on your journey.\r\n\r\n',2,2),(9,'Nike Blazer Mid \'77','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/50a52504-af25-4f2c-b97d-dcf4def22103/blazer-mid-77-shoe-2PCxLw.png',100,'Nike Blazer Mid \'77','Nike Blazer Mid \'77',2,1),(13,'LVXNBA ZIP-THROUGH HOODIE','https://us.louisvuitton.com/images/is/image/lv/1/PP_VP_L/louis-vuitton-lvxnba-zip-through-hoodie-ready-to-wear--HLA01WUZD650_PM2_Front%20view.png?wid=656&hei=656',2880,'100% Cotton','This relaxed hoodie channels the season\'s NBA theme in an array of embroidered patches, with cream topstitching. It is tailored in a slightly loose fit, from a cotton jacquard Monogram base that has been specially washed to create a vintage effect. Details include a gold zip, adjustable hood, kangaroo pockets and an elasticated waist and cuffs.',7,1),(14,'RS-DREAMER Basketball Shoes','https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_2000,h_2000/global/193990/16/fnd/PNA/fmt/png/RS-DREAMER-Basketball-Shoes',125,'Nrgy Red-Puma Black','Donât sleep on your dreams. They keep us grinding and thriving. To celebrate J. Cole and othersâ drive to chase their dreams, weâre releasing new colorways of the RS-DREAMER. The bold elements of the RS series meet street and court ready design for a fully playable pair of kicks. As the DREAMER franchise continues to make strides as a service company for athletes and dreamers everywhere, weâre releasing this drop as a reminder to never stop striving for your highest potential.',6,1),(15,'Chuck 70 Seasonal ','https://www.converse.com.vn/pictures/catalog/products/sneakers/2021/ctas/170790c/170790Cshot2.jpg',100,'Terracotta Pink/Egret/Egret','Very beautiful model, high quality',3,1),(16,'Air Jordan 7 Retro','https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5,q_80/03248e73-d612-491f-81cb-519255551bf1/air-jordan-7-retro-shoe-xbNFP8.png',250,'White/Flint Grey/Black/Varsity','Inspired by the shoe originally worn by MJ during the \'92 season and summer of basketball, the Air Jordan 7 Retro revives its championship legacy for a new generation of sneakerheads.',2,1),(17,'Gucci Horsebit 1955','https://media.gucci.com/style/DarkGray_Center_0_0_800x800/1618591503/658574_18YSG_1060_001_077_0067_Light-Gucci-Horsebit-1955-mini-bag.jpg',2700,'Black leather','Petite versions of the Gucci Horsebit 1955 add a hybrid twist to the vintage inspired line. Enriched with two different shoulder straps, the black leather mini bagâs character transforms from understated elegance with a tonal leather strap to a strong logo feel thanks to a red and green Web option.',4,1),(18,'Converse x Keith Haring Chuck 70 High-Top','https://www.converse.com.vn/pictures/catalog/products/sneakers/2021/ctas/171858v/171858Cshot2.jpg',100,'Black/white','Profesional',3,1),(19,'GG embossed backpack','https://media.gucci.com/style/DarkGray_Center_0_0_800x800/1612461607/658579_1W3BN_9099_001_092_0000_Light-GG-embossed-backpack.jpg',1100,'White GG embossed leathe','A new backpack shape introduced for Ouverture in a medium size with a front pocket that has a magnetic closure. Part of the Houseâs codes first presented during the â30s, the distinctive GG motif has been the inspiration for new explorations of expression for almost a century.',4,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-08 14:11:46
