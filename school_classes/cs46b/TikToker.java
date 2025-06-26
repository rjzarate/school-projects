package tiktoks;

public class TikToker implements Comparable<TikToker> {

		private int numFollowers;
		private String creator;
		
		public TikToker(String creator, int numFollowers) {
			this.creator = creator;
			this.numFollowers = numFollowers;
			
		}
		
		@Override
		public boolean equals(Object o) {
			TikToker that = (TikToker)o;
			return this.compareTo(that)==0;	
		}
		
		@Override
		public int hashCode() {
			return creator.hashCode()+numFollowers;
		}
		
		/*
         * Firt comapres by number of followers
         * Then by the creator name
         *
         */
		public int compareTo(TikToker that) {
			return -1;

		}
		
		@Override
		public String toString() {
			return "("+creator + "; " + numFollowers + ")";
		}

}


