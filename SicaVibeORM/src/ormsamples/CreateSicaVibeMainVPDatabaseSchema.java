/**
 * Licensee: vicshadow(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateSicaVibeMainVPDatabaseSchema {
	public static void main(String[] args) {
		try {
			ORMDatabaseInitiator.createSchema(sicavibe.SicaVibeMainVPPersistentManager.instance());
			sicavibe.SicaVibeMainVPPersistentManager.instance().disposePersistentManager();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
