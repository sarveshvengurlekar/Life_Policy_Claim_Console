package com.hdfclife.service;

import com.hdfclife.exception.PolicyServiceException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AuditLogger implements AutoCloseable{

    private BufferedWriter writer;
        public AuditLogger() {
            try {
                writer = new BufferedWriter(
                        new FileWriter("audit.log", true));
            } catch (IOException e) {
                throw new PolicyServiceException(
                        "Unable to open audit log",
                        e);
            }
        }

        public void log(String message) {
            try {
                writer.write(message);
                writer.newLine();
            } catch (IOException e) {
                throw new PolicyServiceException(
                        "Unable to write audit log",
                        e);
            }

        }

        @Override
        public void close() {
            try {
                if (writer != null) {
                    writer.close();
                }

            } catch (IOException e) {

                throw new PolicyServiceException(
                        "Unable to close audit log",
                        e);
            }

        }

    }

