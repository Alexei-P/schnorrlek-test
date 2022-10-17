import io.emeraldpay.polkaj.schnorrkel.Schnorrkel;
import io.emeraldpay.polkaj.schnorrkel.SchnorrkelException;
import org.apache.commons.codec.binary.Hex;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class SchnorkellTest {
    @Test
    public void testDerivation() throws SchnorrkelException {
        Schnorrkel instance = Schnorrkel.getInstance();
        Schnorrkel.KeyPair keyPair = instance.generateKeyPair();

        byte[] secretKey = keyPair.getSecretKey();
        String secretKey1 = Hex.encodeHexString(secretKey);
        System.out.println("SecretKey: " + secretKey1);

        byte[] privKey = Arrays.copyOfRange(secretKey, 0, 32);
        String privKey1 = Hex.encodeHexString(privKey);
        System.out.println("PrivKey = " + privKey1);

        byte[] chainCode = Arrays.copyOfRange(secretKey, secretKey.length - 32, secretKey.length);
        String chainCode1 = Hex.encodeHexString(chainCode);
        System.out.println("ChainCode = " + chainCode1);

        byte[] publicKey1 = keyPair.getPublicKey();
        String public1 = Hex.encodeHexString(publicKey1);
        Schnorrkel.PublicKey base = new Schnorrkel.PublicKey(publicKey1);
        System.out.println("PublicKey1: " + public1);
    }
}
