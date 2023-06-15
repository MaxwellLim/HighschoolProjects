/**
 * Created by 131225 on 9/4/2018.
 */
public class GuitarString {
    private int tic;
    private int N;
    private RingBuffer string;
    final double EDFactor = .994;

    public GuitarString(double frequency) // create a guitar string of the given frequency, using a sampling rate of 44,100
    {
        tic = 0;
        N = (int) Math.ceil(44100 / frequency);
        string = new RingBuffer(N);
        while (!string.isFull())
            string.enqueue(0);


    }

    public GuitarString(double[] init) // create a guitar string whose size and initial values are given by the array
    {
        tic = 0;
        N = init.length;
        string = new RingBuffer(N);
        for (int x = 0; x < N; x++)
            string.enqueue(init[x]);
    }

    void pluck() // set the buffer to white noise
    {
        for (int x = 0; x < N; x++) {
            string.enqueue(Math.random() -0.5);

        }


    }

    void tic() // advance the simulation one time step
    {
        double first = string.dequeue();
        double second = sample();
        string.enqueue(((first + second) / 2) * EDFactor);
        tic++;

    }

    double sample() // return the current sample
    {
        return string.peek();
    }

    int time() // return number of tics
    {
        return tic;
    }

}
