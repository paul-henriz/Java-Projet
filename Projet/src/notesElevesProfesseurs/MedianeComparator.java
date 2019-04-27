package notesElevesProfesseurs;

import java.util.Comparator;

public class MedianeComparator implements Comparator<Eleve> {
	@Override
	public int compare(Eleve o1, Eleve o2) {
		if (o1.getMediane() > o2.getMediane())
			return 1;
		else if (o1.getMediane() == o2.getMediane())
			return 0;
		else
			return -1;
	}
}
