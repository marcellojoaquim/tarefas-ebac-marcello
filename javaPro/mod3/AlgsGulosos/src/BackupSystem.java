import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BackupSystem {
    public interface Batch {
        int[] getFileSizes();
        int getTapeSize();
    }

    private static class NewBatch implements Batch {

        @Override
        public int[] getFileSizes() {
            return new int[]{70, 10, 20, 10, 50, 40, 50, 100, 60, 100};
        }

        @Override
        public int getTapeSize() {
            return 100;
        }
    }

    private class Tape {
        private int stored;
        private int numberOfFiles;

        public Tape(int stored) {
            this.stored = stored;
            this.numberOfFiles = 1;
        }

        public int getStored() {
            return stored;
        }

        public int getNumberOfFiles() {
            return numberOfFiles;
        }

        public void addStorage(int storage) {
            this.stored += storage;
        }

        public void addFiles() {
            this.numberOfFiles++;
        }

    }

    public int getMinimumTapeCount(final Batch batch) {
        int[] sizes = batch.getFileSizes();
        Arrays.sort(sizes);

        int tapes = 0;
        List<Tape> list = new ArrayList<>();

        for(int i = sizes.length-1; i>-1; i--){
            boolean stored = false;

            for(Tape tape: list){
                if(((tape.getStored() + sizes[i]) <= batch.getTapeSize()) &&(tape.getNumberOfFiles() < 2)) {
                    tape.addStorage(sizes[i]);
                    tape.addFiles();
                    stored = true;
                    break;
                }
            }

            if(!stored) {
                tapes++;
                list.add(new Tape(sizes[i]));
            }
        }

        return tapes;
    }

    public static void main(String[] args) {
        BackupSystem backupSystem = new BackupSystem();
        BackupSystem.Batch batch = new NewBatch();

        System.out.println(backupSystem.getMinimumTapeCount(batch));
    }
}
