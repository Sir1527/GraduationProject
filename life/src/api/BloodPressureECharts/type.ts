export interface BloodPressureECharts {
    time?: Array<string>;
    sbp?: Array<string>;
    dbp?: Array<string>;
}

export interface respBloodPressureECharts {
    code?: string;
    msg?: string,
    data?: BloodPressureECharts;
}

export interface BloodPressureAdd {
    userId?: string,
    sbp?: string,
    dbp?: string
}