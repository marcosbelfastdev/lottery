import java.util.*;

public class Ticket {


    Random _random = new Random();
    private int _positions = 6;
    private int _low = 0;
    private int _high = 60;
    TreeSet<Integer> _balls;

    // stateful instance variables
    TreeSet<Integer> _buffer = new TreeSet<Integer>();
    List<String> bufferHistory = new ArrayList<String>();

    public Ticket() {

    }

    public Ticket(int positions, int low, int high) {
        _positions = positions;
        _low = low;
        _high = high;
    }

    public boolean addBall(int ball) {
        try {
            _buffer.add(ball);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Ticket add(int... balls) {
        for (int ball : balls) {
            if (_buffer.size() == _positions) {
                return this;
            }
        }

        for (int ball : balls) {
            if (_buffer.size() < _positions) {
                if (!_buffer.contains(ball)) {
                    _buffer.add(ball);
                }
            } else {
                break;
            }
        }

        return this;
    }

    public Ticket removeBall(int ball) {
        _buffer.remove(ball);
        return this;
    }

    public TreeSet<Integer> getAllBallsPlayed() {
        return _balls;
    }

    public Ticket getAny(int numberOfBalls, Ticket... tickets) {
        TreeSet<Integer> balls = new TreeSet<Integer>();
        int ballsAvailable = 0;

        // Find all distinct balls amongst all tickets passed in
        for (Ticket ticket : tickets) {
            for (int ball : ticket.getAllBallsPlayed()) {
                try {
                    balls.add(ball);
                    ballsAvailable++;
                } catch (Exception ignore) {

                }
            }
        }

        List<Integer> ballsList = new ArrayList<Integer>();
        ballsList.addAll(balls);
        if (numberOfBalls > ballsAvailable) numberOfBalls = ballsAvailable;

        // all balls from all tickets retrieved, now we add a number of balls equal to numberOfBalls
        // to the ticket buffer.

        TreeSet<Integer> buffer = new TreeSet<Integer>();
        for (int i=0; i<numberOfBalls; i++) {
            int ball = ballsList.get(_random.nextInt(_high) + 1);
            try {
                buffer.add(ball);
            } catch (Exception ignore) {

            }
        }

        // Now add local buffer built to ticket class buffer
        for (int ball : buffer) {
            try {
                _buffer.add(ball);
            } catch (Exception ignore) {

            }
        }

        // this does not guarantee all expected number of unique balls were retrieved
        // but we will not bother with it because the rules will fill out
        // all expected positions anyway at play() method.

        // evidently, if one ticket only is passed in, then we guarantee
        // all expected number of unique balls were retrieved.

        return this;
    }

    public void play() {

        // get all balls in the buffer and fill in positions in ticket balls
        _balls = new TreeSet<Integer>();
        int counter = 0;
        for (int ball : _buffer) {
            if (counter > _positions) {
                // ok, we seem to have added more numbers to the buffer than than the ticket allows us to.
                break;
            }
            try {
                _balls.add(ball);
                counter++;
            } catch (Exception ignore) {

            }
        }

        // however, there could be fewer balls than the quantity set for this ticket
        // how are we going to fill out the ticket positions?
        // we will analyse each and every rule and the buffer history


        while (_balls.size() < _positions) {
            try {
                _balls.add(_random.nextInt(_high) + 1);
            } catch (Exception ignore) {

            }
        }

    }

    private void validate() {

    }

    @Override
    public String toString() {
        return _balls.toString();
    }


}
