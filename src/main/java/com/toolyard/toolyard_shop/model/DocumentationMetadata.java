package com.toolyard.toolyard_shop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DocumentationMetadata {
    @Column(name = "storage_object_id")
    private String storageObjectId; // Идентификатор файла в Yandex Object Storage

    @Column(name = "storage_path")
    private String storagePath; // Путь к файлу в бакете
    @Column(name = "original_file_name")
    private String originalFileName;
    @Column(name = "file_size")
    private long fileSize;
    @Column(name = "content_type")
    private String contentType;
}
