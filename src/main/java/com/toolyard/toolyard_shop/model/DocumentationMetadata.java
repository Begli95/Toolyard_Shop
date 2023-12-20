package com.toolyard.toolyard_shop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DocumentationMetadata {
    @Column(name = "storage_object_id")
    private String storageObjectId;
    @Column(name = "storage_path")
    private String storagePath;
    @Column(name = "original_file_name")
    private String originalFileName;
    @Column(name = "file_size")
    private long fileSize;
    @Column(name = "content_type")
    private String contentType;
}
