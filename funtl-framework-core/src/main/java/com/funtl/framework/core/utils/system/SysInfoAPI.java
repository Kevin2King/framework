package com.funtl.framework.core.utils.system;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.text.DecimalFormat;

/**
 * 系统信息API
 * Created by 李卫民 on 2016/5/14.
 *
 * @see SysInfo
 */
public class SysInfoAPI {
    private static DecimalFormat df = new DecimalFormat("#0.00");

    /**
     * 物理内存总量
     */
    public static long getMemoryTotal() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        return mem.getTotal() / 1024 / 1024;
    }

    /**
     * 已用物理内存
     */
    public static long getMemoryUsed() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        return mem.getUsed() / 1024 / 1024; // MB
    }

    /**
     * 物理内存使用率
     */
    public static double getMemoryPercent() throws SigarException {
        Sigar sigar = new Sigar();
        Mem mem = sigar.getMem();
        return new Double(df.format(mem.getUsedPercent()));
    }

    /**
     * CPU总使用率
     */
    public static double getCpuCombined() throws SigarException {
        Sigar sigar = new Sigar();
        CpuPerc cpuPerc = sigar.getCpuPerc();
        return new Double(df.format(cpuPerc.getCombined() * 100));
    }
}
