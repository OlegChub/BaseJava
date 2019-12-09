package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    final private static int SIZE = 3;
    private int currentSize = 0;
    private Resume[] storage = new Resume[SIZE];

    public void clear() {
        for (int i = 0; i < currentSize; i++) {
            storage[i] = null;
        }
        currentSize = 0;
    }

    public void save(Resume r) {
        boolean isExist = false;
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                isExist = true;
                System.out.println(r + " was already added to the system");
            }
        }
        if (isExist == false) {
            storage[currentSize] = r;
            currentSize++;
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        int index = -1;
        boolean isExist = false;
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].getUuid() == uuid) {
                index = i;
                isExist = true;
            }
        }
        if (isExist) {
            for (int i = index; i < currentSize - 1; i++) {
                storage[i] = storage[i + 1];
            }
            storage[currentSize - 1] = null;
            currentSize--;
        } else {
            System.out.println(uuid + " is not found");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] allResume = new Resume[currentSize];
        for (int i = 0; i < currentSize; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    public int size() {
        return currentSize;
    }
}