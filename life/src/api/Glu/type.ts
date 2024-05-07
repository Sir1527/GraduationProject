export interface GluECharts {
    glu?: Array<number>;
    time?: Array<string>;
}

export interface respGluECharts {
    code: number;
    message: string;
    data: GluECharts;
}

export interface GluAdd {
    userId?: string;
    glu?: number;
}