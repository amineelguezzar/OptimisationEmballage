package fr.vsct.emballage;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OptimisationCarton {

	public OptimisationCarton() {
	}

	public static String optimiserStokageArtile(String articles, int limiteCarton) throws NumberFormatException {

		StringBuilder sb = new StringBuilder();
		List<Integer> listInputs = Pattern.compile("").splitAsStream(articles)
				.mapToInt(Integer::valueOf).boxed()
				.collect(Collectors.toList());

		List<Integer> listTags = new ArrayList<Integer>();
		int sizeInputs = listInputs.size();

		for (int i = 0; i < sizeInputs - 1; i++) {
			
			int sum = listInputs.get(i) + listInputs.get(i + 1);
			while (sum <= limiteCarton) {
				if (sum == limiteCarton) {
					i++;
				}
				i++;
				if (i < sizeInputs - 1) {
					sum += listInputs.get(i + 1);
				} else {
					listTags.add(i);
					break;
				}
			}

			while (sum > limiteCarton) {
				listTags.add(i);
				int bestValue = limiteCarton - listInputs.get(i);
				while (bestValue > 0
						&& !listInputs.subList(i + 1, sizeInputs)
								.contains(bestValue)) {
					bestValue--;
				}
				if (bestValue > 0) {
					int index = listInputs.lastIndexOf(bestValue);
					listInputs.add(i + 1, bestValue);
					listInputs.remove(index + 1);
					i--;
				} else {
					listTags.add(i + 1);
				}
				break;
			}
		}
		
		for (int i = 0; i < listInputs.size(); i++) {
			sb.append(listInputs.get(i));
			if (listTags.contains(i + 1)) {
				sb.append("/");
			}
		}
		return sb.toString();

	}
}
