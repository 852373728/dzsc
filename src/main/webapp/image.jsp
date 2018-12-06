<%@ page contentType="image/jpeg"
	import="java.awt.*,
java.awt.image.*,java.util.*,javax.imageio.*" pageEncoding="utf-8"%>
<%!
Color getRandColor(int fc,int bc)
{
Random random = new Random();
if(fc>255) fc=255;
if(bc>255) bc=255;
int r=fc+random.nextInt(bc-fc);
int g=fc+random.nextInt(bc-fc);
int b=fc+random.nextInt(bc-fc);
return new Color(r,g,b);
}
%>
<%
out.clear();//这句针对resin服务器，如果是tomacat可以不要这句
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
int width=130, height=50;
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
Graphics g = image.getGraphics();
Random random = new Random();
//g.setColor(getRandColor(200,250));
g.fillRect(0, 0, width, height);
g.setFont(new Font("Times New Roman",Font.PLAIN,height));
//g.setColor(getRandColor(160,200));
for (int i=0;i<155;i++)
{
int x = random.nextInt(width);
int y = random.nextInt(height);
int xl = random.nextInt(12);
int yl = random.nextInt(12);
g.drawLine(x,y,x+xl,y+yl);
}
String sRand="";
for (int i=0;i<4;i++){
String chars="abcdefghijkmnpqrstwvuxyz23456789";
String rand=String.valueOf(chars.charAt((int)(Math.random() * 32)));
sRand+=rand;
g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
g.drawString(rand,30*i+8,40);
}
// 将认证码存入SESSION
session.setAttribute("sRand",sRand);
g.dispose();
ImageIO.write(image, "JPEG", response.getOutputStream());
%>