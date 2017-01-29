/*
 * Copyright (c) 2015 Samelamin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.samelamin.spark.bigquery

import org.apache.spark.sql.{DataFrameWriter, Row}

class DataFrameWriterFunctions(@transient val dfw: DataFrameWriter[Row]) extends Serializable {

  /**
    * The classpath to the default source
    */
  private val source = "com.samelamin.spark.bigquery.DefaultSource"
  /**
    * Helper method to write the current DataFrame to bigquery.
    */
  private def writeFrame(options: Map[String, String] = null): Unit = {
    val builder = dfw
      .format(source)

    if (options != null) {
      builder.options(options)
    }

    builder.save()
  }

}
