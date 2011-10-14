/*
 * Copyright (C) 2010, Zenoss Inc.  All Rights Reserved.
 */
package org.zenoss.utils.dao.impl;

import java.sql.Timestamp;
import java.util.Map;

import org.zenoss.utils.dao.Partition;

/**
 * Represents the configuration of a MySQL table partition (loaded from the
 * INFORMATION_SCHEMA.PARTITIONS table).
 */
public class MySqlPartition implements Partition {
    private String tableCatalog = null;
    private String tableSchema;
    private String tableName;
    private String partitionName;
    private String subpartitionName;
    private Timestamp rangeLessThan = null;
    private Timestamp rangeMinimum = null;
    private Long partitionOrdinalPosition;
    private Long subpartitionOrdinalPosition;
    private String partitionMethod;
    private String subpartitionMethod;
    private String partitionColumn;
    private String subpartitionExpression;
    private String partitionDescription;
    private long tableRows;
    private long avgRowLength;
    private long dataLength;
    private Long maxDataLength;
    private long indexLength;
    private long dataFree;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp checkTime;
    private Long checksum;
    private String partitionComment;
    private String nodeGroup;
    private String tablespaceName;

    private MySqlPartition() {
    }

    public String getTableCatalog() {
        return tableCatalog;
    }

    public String getTableSchema() {
        return tableSchema;
    }

    @Override
    public String getTableName() {
        return tableName;
    }

    @Override
    public String getPartitionName() {
        return partitionName;
    }

    public String getSubpartitionName() {
        return subpartitionName;
    }

    public Long getPartitionOrdinalPosition() {
        return partitionOrdinalPosition;
    }

    public Long getSubpartitionOrdinalPosition() {
        return subpartitionOrdinalPosition;
    }

    public String getPartitionMethod() {
        return partitionMethod;
    }

    public String getSubpartitionMethod() {
        return subpartitionMethod;
    }

    @Override
    public String getPartitionColumn() {
        return partitionColumn;
    }

    public String getSubpartitionExpression() {
        return subpartitionExpression;
    }

    public String getPartitionDescription() {
        return partitionDescription;
    }

    public long getTableRows() {
        return tableRows;
    }

    public long getAvgRowLength() {
        return avgRowLength;
    }

    public long getDataLength() {
        return dataLength;
    }

    public Long getMaxDataLength() {
        return maxDataLength;
    }

    public long getIndexLength() {
        return indexLength;
    }

    public long getDataFree() {
        return dataFree;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public Timestamp getCheckTime() {
        return checkTime;
    }

    public Long getChecksum() {
        return checksum;
    }

    public String getPartitionComment() {
        return partitionComment;
    }

    public String getNodeGroup() {
        return nodeGroup;
    }

    public String getTablespaceName() {
        return tablespaceName;
    }

    @Override
    public Timestamp getRangeLessThan() {
        return rangeLessThan;
    }

    @Override
    public Timestamp getRangeMinimum() {
        return rangeMinimum;
    }

    void setRangeMinimum(Timestamp minimum) {
        this.rangeMinimum = minimum;
    }

    @Override
    public String toString() {
        return String
                .format("MySqlPartition [tableCatalog=%s, tableSchema=%s, tableName=%s, "
                        + "partitionName=%s, subpartitionName=%s, "
                        + "partitionOrdinalPosition=%s, "
                        + "subpartitionOrdinalPosition=%s, partitionMethod=%s, "
                        + "subpartitionMethod=%s, partitionColumn=%s, "
                        + "subpartitionExpression=%s, partitionDescription=%s, "
                        + "tableRows=%s, avgRowLength=%s, dataLength=%s, "
                        + "maxDataLength=%s, indexLength=%s, dataFree=%s, "
                        + "createTime=%s, updateTime=%s, checkTime=%s, "
                        + "checksum=%s, partitionComment=%s, nodeGroup=%s, "
                        + "tablespaceName=%s]", tableCatalog, tableSchema,
                        tableName, partitionName, subpartitionName,
                        partitionOrdinalPosition, subpartitionOrdinalPosition,
                        partitionMethod, subpartitionMethod,
                        partitionColumn, subpartitionExpression,
                        partitionDescription, tableRows, avgRowLength,
                        dataLength, maxDataLength, indexLength, dataFree,
                        createTime, updateTime, checkTime, checksum,
                        partitionComment, nodeGroup, tablespaceName);
    }

    public static MySqlPartition fromMySqlResultSetFields(Map<String, Object> fields) {
        MySqlPartition partition = new MySqlPartition();
        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            final String field = entry.getKey();
            final Object val = entry.getValue();
            if (val == null) {
                continue;
            }
            if ("TABLE_CATALOG".equals(field)) {
                partition.tableCatalog = (String) val;
            } else if ("TABLE_SCHEMA".equals(field)) {
                partition.tableSchema = (String) val;
            } else if ("TABLE_NAME".equals(field)) {
                partition.tableName = (String) val;
            } else if ("PARTITION_NAME".equals(field)) {
                partition.partitionName = (String) val;
            } else if ("SUBPARTITION_NAME".equals(field)) {
                partition.subpartitionName = (String) val;
            } else if ("PARTITION_ORDINAL_POSITION".equals(field)) {
                partition.partitionOrdinalPosition = ((Number) val).longValue();
            } else if ("SUBPARTITION_ORDINAL_POSITION".equals(field)) {
                partition.subpartitionOrdinalPosition = ((Number) val).longValue();
            } else if ("PARTITION_METHOD".equals(field)) {
                partition.partitionMethod = (String) val;
            } else if ("SUBPARTITION_METHOD".equals(field)) {
                partition.subpartitionMethod = (String) val;
            } else if ("PARTITION_EXPRESSION".equals(field)) {
                partition.partitionColumn = (String) val;
            } else if ("SUBPARTITION_EXPRESSION".equals(field)) {
                partition.subpartitionExpression = (String) val;
            } else if ("PARTITION_DESCRIPTION".equals(field)) {
                partition.partitionDescription = (String) val;
            } else if ("TABLE_ROWS".equals(field)) {
                partition.tableRows = ((Number) val).longValue();
            } else if ("AVG_ROW_LENGTH".equals(field)) {
                partition.avgRowLength = ((Number) val).longValue();
            } else if ("DATA_LENGTH".equals(field)) {
                partition.dataLength = ((Number) val).longValue();
            } else if ("MAX_DATA_LENGTH".equals(field)) {
                partition.maxDataLength = ((Number) val).longValue();
            } else if ("INDEX_LENGTH".equals(field)) {
                partition.indexLength = ((Number) val).longValue();
            } else if ("DATA_FREE".equals(field)) {
                partition.dataFree = ((Number) val).longValue();
            } else if ("CREATE_TIME".equals(field)) {
                partition.createTime = (Timestamp) val;
            } else if ("UPDATE_TIME".equals(field)) {
                partition.updateTime = (Timestamp) val;
            } else if ("CHECK_TIME".equals(field)) {
                partition.checkTime = (Timestamp) val;
            } else if ("CHECKSUM".equals(field)) {
                partition.checksum = ((Number) val).longValue();
            } else if ("PARTITION_COMMENT".equals(field)) {
                partition.partitionComment = (String) val;
            } else if ("NODEGROUP".equals(field)) {
                partition.nodeGroup = (String) val;
            } else if ("TABLESPACE_NAME".equals(field)) {
                partition.tablespaceName = (String) val;
            }
        }
        if ("RANGE".equals(partition.partitionMethod)) {
            if ("MAXVALUE".equalsIgnoreCase(partition.partitionDescription)) {
                partition.rangeLessThan = new Timestamp(Long.MAX_VALUE);
            } else {
                partition.rangeLessThan = new Timestamp(Long.parseLong(partition.partitionDescription));
            }
        }
        return partition;
    }
}
