/**
 * 
 */
package fr.vsct.emballage;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Aelguezzar Test class {@link OptimisationCarton}.
 */
@RunWith(Parameterized.class)
public class OptimisationCartonTest {

	private String articles;
	private String resultat;
	private int limiteCarton;

	@Parameterized.Parameters
	public static Collection getParametres() {
		return Arrays.asList(new Object[][] { { "", "", 10 }, { "1", "1", 10 },
				{ "163841689525773", "163/82/46/19/8/55/73/7", 10 }});
	}

	public OptimisationCartonTest(String articles, String resultat, int limiteCarton) {
		this.articles = articles;
		this.resultat = resultat;
		this.limiteCarton = limiteCarton;
	}

	@Test
	public void optimiserStokageArtile() {
		Assert.assertEquals(resultat,
				OptimisationCarton.optimiserStokageArtile(articles, limiteCarton));
	}
}
