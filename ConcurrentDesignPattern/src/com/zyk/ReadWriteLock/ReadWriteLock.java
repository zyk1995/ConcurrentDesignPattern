package com.zyk.ReadWriteLock;

public final class ReadWriteLock {
    private int readingReaders = 0;
    private int waitingWriters = 0;
}
