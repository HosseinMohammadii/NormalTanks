package Blocks;
/**
 * this class is extends from wall
 */

    public class Plant extends Wall{
    /**
     * give position in its constructor
     * @param x
     * @param y
     */
        public Plant (int x, int y) {
            super( x, y );
            type=203;

        }

        @Override
        public void hurt(int damage) {

        }
        //the size of height and width is 100


    }


