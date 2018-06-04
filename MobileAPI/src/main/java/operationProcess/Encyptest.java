package operationProcess;



import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class Encyptest {
  
  
private String key;
private String initializationVector;

public static void main(String[] arg){
                  
	Encyptest decodeEncode = new Encyptest("cambodiaasiancambopay123","@#$&XxZ+12341234");
  try {
    String strencode = decodeEncode.encryptText("Hello123");
    System.out.println(strencode);
    
    String strdecode = decodeEncode.decryptText("tM6WoPiFJM16u5VcItdzRA==");
    System.out.println(strdecode);
  } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  
}

public Encyptest(String key, String initializationVector)
{
this.key = key;
this.initializationVector = initializationVector;
}


public String encryptText(String plainText) throws Exception{ 
byte[] plaintext = plainText.getBytes();
byte[] tdesKeyData = key.getBytes(); 
Cipher c3des = Cipher.getInstance("AES/CBC/PKCS5Padding");
SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "AES");
IvParameterSpec ivspec = new IvParameterSpec(initializationVector.getBytes());
c3des.init(Cipher.ENCRYPT_MODE, myKey, ivspec);
byte[] cipherText = c3des.doFinal(plaintext);
return new sun.misc.BASE64Encoder().encode(cipherText);
}



public String decryptText(String cipherText)throws Exception{
byte[] encData = new sun.misc.BASE64Decoder().decodeBuffer(cipherText);
Cipher decipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
byte[] tdesKeyData = key.getBytes();
SecretKeySpec myKey = new SecretKeySpec(tdesKeyData, "AES");
IvParameterSpec ivspec = new IvParameterSpec(initializationVector.getBytes());
decipher.init(Cipher.DECRYPT_MODE, myKey, ivspec);
byte[] plainText = decipher.doFinal(encData);
return new String(plainText);
}
}