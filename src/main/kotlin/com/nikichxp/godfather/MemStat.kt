package com.nikichxp.godfather

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit
import kotlin.math.ln
import kotlin.math.pow

@Service
class MemoryStatusReports {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Scheduled(fixedDelay = 1L, timeUnit = TimeUnit.MINUTES)
    fun printMemStat() {
        logger.info(getObjectOutput().toString())
    }

    fun getObjectOutput(): Pair<String, Any> = "memoryProfile" to mapOf(
        "used" to formatMemorySize(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()),
        "free" to formatMemorySize(Runtime.getRuntime().freeMemory()),
        "allocated" to formatMemorySize(Runtime.getRuntime().totalMemory())
    )

    private fun formatMemorySize(size: Long): String {
        val unit = 1024
        if (size < unit) return "$size B"
        val exp = (ln(size.toDouble()) / ln(unit.toDouble())).toInt()
        val pre = "KMGTPE"[exp - 1] + "i"
        return String.format("%.1f %sB", size / unit.toDouble().pow(exp.toDouble()), pre)
    }

}