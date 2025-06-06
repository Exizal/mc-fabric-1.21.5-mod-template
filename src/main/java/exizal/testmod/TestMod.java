// In src/main/java/exizal/testmod/TestMod.java

package exizal.testmod;

import exizal.testmod.entity.ModEntities; // This import should now be correct
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "test-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This line runs the registration code from ModEntities.
		ModEntities.registerModEntities();
	}
}