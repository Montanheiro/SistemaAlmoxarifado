package business;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author lucas
 */
public class Token {
    
    public static String Gerate(String issuer, int idSubject, int hours) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        
        //Hours to milliseconds
        long ttlMillis = hours * 3600000;
        String subject = String.valueOf(idSubject);
        
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        
        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Parameters.TOKENKEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setIssuedAt(now)
                                    .setSubject(subject)
                                    .setIssuer(issuer)
                                    .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
        long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
    
    //Sample method to validate and read the JWT
    public static boolean Verify(String jwt, String type) throws Exception {
        
        try{
            Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(Parameters.TOKENKEY))
                .parseClaimsJws(jwt).getBody();
            
            //verifica se o issuer é igual ao type
            return claims.getIssuer().equals(type);
            
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException 
                | UnsupportedJwtException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static String Password(String passOrigin) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(passOrigin.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }
    
    public static int getSubject(String jwt) throws Exception{
        
            Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(Parameters.TOKENKEY))
                .parseClaimsJws(jwt).getBody();
            
            //retorna o sujeito do token
            return Integer.parseInt(claims.getSubject());

    }
}
