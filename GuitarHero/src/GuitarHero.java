public class GuitarHero {
    public static void main(String[] args) {


        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        GuitarString[] strings = new GuitarString[keyboard.length()];

        double f;
        for (int i = 0; i < keyboard.length(); i++) {
            f = (440 * Math.pow(1.05956, i - 24));
            strings[i] = new GuitarString(f);
        }


        // the main input loop
        while (true) {

            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                if (keyboard.contains(String.valueOf(key)))
                    strings[keyboard.indexOf(key)].pluck();
            }

            // compute the superposition of the samples

            double sample = 0;
            for (GuitarString s : strings) {
                sample += s.sample();
            }

            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (GuitarString s : strings) {
                s.tic();
            }
        }
    }

}
