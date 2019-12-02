/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    final private static int SIZE = 10000;
    private int currentSize = 0;
    final private Resume[] storage = new Resume[SIZE];

    void clear() {
        for (int i = 0; i < currentSize; i++) {
            storage[i] = null;
        }
        currentSize = 0;
    }

    void save(Resume r) {
        storage[currentSize] = r;
        currentSize++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = -1;
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].uuid == uuid) {
                index = i;
            }
        }
        for (int i = index; i < currentSize; i++) {
            storage[i] = storage[i + 1];
        }
        currentSize--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[currentSize];
        for (int i = 0; i < currentSize; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    int size() {
        return currentSize;
    }

}